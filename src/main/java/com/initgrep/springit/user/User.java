package com.initgrep.springit.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.initgrep.springit.role.Role;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
public class User implements UserDetails {

	private static final long serialVersionUID = 2596237857607701287L;

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	@Size(min = 8, max = 50)
	@Column(nullable = false, unique = true)

	private String email;

	@NonNull
	@Column(nullable = false)
	private String password;
	
	@NonNull
	private Boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name ="USERS_ROLES",
			joinColumns = @JoinColumn(name="USER_ID", referencedColumnName ="id"),
			inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id")
			)
	private Set<Role> roles = new HashSet<>();

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(role -> 
				new SimpleGrantedAuthority(role.getName())
				).collect(Collectors.toList());
		
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}
	
	public void addRoles(Set<Role> roles) {
		roles.forEach(this::addRole);
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}



}
