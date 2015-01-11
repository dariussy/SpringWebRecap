#Spring security :

##First solution : 

Encodage password dans le services en locurrence UserService avant la sauvgarde en BD

```java
	public User save(User u) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(u.getPassword());
		u.setPassword(hashedPassword);
		return dao.save(u);
	}
```

Configuration de spring-security.xml pour la connection avec mpd encoder : 

```xml
<authentication-provider>
		    <password-encoder hash="bcrypt"/>
			<jdbc-user-service data-source-ref="dataSource"
				users-by-username-query="SELECT login as USERNAME, PASSWORD, CASE ENABLED WHEN 1 THEN 'true' ELSE 'true' END 'ENABLED' 
											FROM user WHERE login=?"
				authorities-by-username-query="select u.login AS USERNAME, p.role AS ROLENAME 
												from user u join user_profile rp on u.id=rp.User_id 
												join profile p on p.id=rp.profiles_id 
												where u.login =?" />
		</authentication-provider>

```

##Configuration avancée :

Configuration de spring-security.xml : 

```xml
	<http auto-config="true" use-expressions="true">
		<intercept-url pattern="/user/**" access="hasRole('ROLE_ADMIN')" />

		<!-- access denied page -->
		<access-denied-handler error-page="/403" />
		<form-login 
		    login-page="/login" 
		    default-target-url="/welcome"
			authentication-failure-url="/login?error" 
			username-parameter="username"
			password-parameter="password" />
		<logout logout-success-url="/login?logout" />
		<!-- enable csrf protection -->
		<csrf />
	</http>

	<authentication-manager>
		<authentication-provider user-service-ref="myUserDetailsService" >
			<password-encoder hash="bcrypt" />    
		</authentication-provider>
	</authentication-manager>

```

Le login fait donc référence a la class myUserDetailsService : 

```java

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDAO userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("$$$$$$$$ login : "+username);
		// Programmatic transaction management
		/*
		return transactionTemplate.execute(new TransactionCallback<UserDetails>() {

			public UserDetails doInTransaction(TransactionStatus status) {
				com.mkyong.users.model.User user = userDao.findByUserName(username);
				List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

				return buildUserForAuthentication(user, authorities);
			}

		});*/
		
		fr.intertek.model.User user = userDao.findByLogin(username);
		System.out.println("else");
		System.out.println("loadUserByUsername:"+user.getLogin()+" pass: "+user.getPassword());
		List<GrantedAuthority> authorities = buildUserAuthority(user.getProfiles());

		return buildUserForAuthentication(user, authorities);
		

	}

	// Converts model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(fr.intertek.model.User user, List<GrantedAuthority> authorities) {
		return new User(user.getLogin(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<Profile> profiles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (Profile profile : profiles) {
			System.out.println("profile : "+profile.getRole());
			setAuths.add(new SimpleGrantedAuthority(profile.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}

```


Pour l'encodeage du password meme principe que le précédant : 

```java
	public User save(User u) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(u.getPassword());
		u.setPassword(hashedPassword);
		return dao.save(u);
	}
```

