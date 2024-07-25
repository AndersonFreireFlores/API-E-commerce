package andersonfflores.ecommerce.Controllers;

import andersonfflores.ecommerce.Configs.Security.TokenService;
import andersonfflores.ecommerce.Models.User.DTOs.AuthenticationDTO;
import andersonfflores.ecommerce.Models.User.DTOs.LoginResponseDTO;
import andersonfflores.ecommerce.Models.User.DTOs.RegisterDTO;
import andersonfflores.ecommerce.Models.User.Enum.UserRole;
import andersonfflores.ecommerce.Models.User.User;
import andersonfflores.ecommerce.Models.User.UserAuthenticated;
import andersonfflores.ecommerce.Repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, UserRepository userRepository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data) {
        var namePassword = new UsernamePasswordAuthenticationToken(data.name(), data.password());
        var auth = authenticationManager.authenticate(namePassword);

        var token = tokenService.generateToken((UserAuthenticated) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data){
        if (this.userRepository.findByName(data.name()).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.name(),data.email(),data.address(), encryptedPassword,
                UserRole.valueOf(data.role()).getRole());
        userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
