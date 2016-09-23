package geppetto.module.bootsecurity.iservices;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ListProject.domain.core.GpUser;

public interface IGpUserService extends UserDetailsService {

	GpUser getLoggedInUser() throws Exception;

}
