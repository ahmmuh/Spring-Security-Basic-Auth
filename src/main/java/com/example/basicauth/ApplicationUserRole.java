package com.example.basicauth;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.basicauth.ApplicationPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(
            STUDENT_WRITE,STUDENT_READ,
            COURSE_WRITE,
            COURSE_READ)),

    ADMINTrainee(Sets.newHashSet(
   STUDENT_READ,COURSE_READ));
    private final Set<ApplicationPermission> permissions;

    ApplicationUserRole(Set<ApplicationPermission> applicationPermission) {
        this.permissions = applicationPermission;
    }

    public Set<ApplicationPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
       Set<SimpleGrantedAuthority> permissions =   getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermissions()))
               .collect(Collectors.toSet());
       permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
       return permissions;
    }


}
