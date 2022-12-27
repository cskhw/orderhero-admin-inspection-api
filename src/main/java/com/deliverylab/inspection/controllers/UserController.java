package com.deliverylab.inspection.controllers;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverylab.inspection.exception.TokenRefreshException;
import com.deliverylab.inspection.models.RefreshToken;
import com.deliverylab.inspection.payload.request.SignupRequest;
import com.deliverylab.inspection.payload.request.TokenRefreshRequest;
import com.deliverylab.inspection.payload.response.TokenRefreshResponse;
import com.deliverylab.inspection.repository.RoleRepository;
import com.deliverylab.inspection.repository.UserRepository;
import com.deliverylab.inspection.security.jwt.JwtUtils;
import com.deliverylab.inspection.security.services.RefreshTokenService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	RefreshTokenService refreshTokenService;

	// auth api 체크용
	@GetMapping("/check")
	public ResponseEntity<?> userCheck() {
		return ResponseEntity.ok("auth check.");
	}

	// access_token 새로 발급
	@PostMapping("/create")
	public ResponseEntity<?> userCreate(@Valid @RequestBody TokenRefreshRequest request) {
		String requestRefreshToken = request.getRefreshToken();

		return refreshTokenService.findByToken(requestRefreshToken)
				.map(refreshTokenService::verifyExpiration)
				.map(RefreshToken::getUser)
				.map(user -> {
					String token = jwtUtils.generateTokenFromUsername(user.getUsername());
					return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
				})
				.orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
						"Refresh token is not in database!"));
	}

	// access-token으로 유저 데이터 가져옴
	@PostMapping("/me")
	public ResponseEntity<?> me(@Valid @RequestBody SignupRequest loginRequest) {
		return ResponseEntity.ok("");
	}

	// 아이디로 유저 조회
	@GetMapping("/read/{id}")
	public ResponseEntity<?> readUserById(@Valid @RequestBody SignupRequest loginRequest) {
		return ResponseEntity.ok("");
	}

	// 이름으로 유저 조회
	@GetMapping("/read/{name}")
	public ResponseEntity<?> readUserByName(@Valid @RequestBody SignupRequest loginRequest) {
		return ResponseEntity.ok("");
	}

	// 유저 페이지네이션
	@PostMapping("/readmany")
	public ResponseEntity<?> userReadMany(@Valid @RequestBody SignupRequest loginRequest) {
		return ResponseEntity.ok("");
	}

	// 유저 데이터 업데이트
	@PostMapping("/update")
	public ResponseEntity<?> userUpdate(@Valid @RequestBody SignupRequest loginRequest) {
		return ResponseEntity.ok("");
	}

	// 유저 데이터 삭제
	@PostMapping("/delete")
	public ResponseEntity<?> userDelete(@Valid @RequestBody SignupRequest loginRequest) {
		return ResponseEntity.ok("");
	}
}
