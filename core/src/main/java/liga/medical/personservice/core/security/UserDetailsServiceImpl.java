package liga.medical.personservice.core.security;

import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.repository.PersonDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PersonDataRepository personDataRepository;

    @Autowired
    public UserDetailsServiceImpl(PersonDataRepository personDataRepository) {
        this.personDataRepository = personDataRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        PersonDataEntity person = personDataRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        return SecurityUser.fromUser(person);
    }
}
