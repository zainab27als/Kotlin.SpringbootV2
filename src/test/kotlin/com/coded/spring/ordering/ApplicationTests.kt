package com.coded.spring.ordering

import com.coded.spring.ordering.orders.OrderRepository
import com.coded.spring.ordering.profiles.ProfileEntity
import com.coded.spring.ordering.profiles.ProfileRepository
import com.coded.spring.ordering.profiles.ProfileRequest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProfileControllerTest {

	@LocalServerPort
	var port: Int = 0

	@Autowired
	lateinit var usersRepository: TalabatRepository

	@Autowired
	lateinit var ordersRepository: OrderRepository

	@Autowired
	lateinit var profileRepository: ProfileRepository

	@Autowired
	lateinit var passwordEncoder: PasswordEncoder

	@Autowired
	lateinit var restTemplate: TestRestTemplate

	lateinit var tokenUsername: String
	lateinit var tokenPassword: String

	@BeforeAll
	fun setUp() {
		val username = "ZainabAlS"
		val rawPassword = "joincoded"
		val existingUser = usersRepository.findByUsername(username)

		if (existingUser == null) {
			val testUser = UserEntity(
				name = "Zainab",
				username = username,
				password = passwordEncoder.encode(rawPassword)
			)
			usersRepository.save(testUser)
		}

		tokenUsername = username
		tokenPassword = rawPassword
	}

	@Test
	fun `authenticated user can create profile`() {
		val request = ProfileRequest(
			firstName = "Zainab",
			lastName = "AlSaffar",
			phoneNumber = "12345678"
		)

		val headers = HttpHeaders().apply {
			contentType = MediaType.APPLICATION_JSON
			setBasicAuth(tokenUsername, tokenPassword)
		}

		val entity = HttpEntity(request, headers)
		val response = restTemplate.postForEntity(
			"http://localhost:$port/profile",
			entity,
			ProfileEntity::class.java
		)

		assertEquals(HttpStatus.OK, response.statusCode)
		assertNotNull(response.body)
		assertEquals("Zainab", response.body?.firstName)
		assertEquals("AlSaffar", response.body?.lastName)
	}
}