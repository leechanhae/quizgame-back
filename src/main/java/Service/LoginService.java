package Service;

import dto.UserDto;
import entity.User;
import repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public UserDto login(String userId, String password) {
        User user = userRepository.findByUserIdAndPassword(userId, password)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        return new UserDto(user.getUserId(), user.getUsername(), user.getPassword());
    }
}
