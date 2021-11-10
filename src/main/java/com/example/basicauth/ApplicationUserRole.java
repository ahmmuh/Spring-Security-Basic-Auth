package com.example.basicauth;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.basicauth.ApplicationPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ,
            COURSE_WRITE,STUDENT_READ,STUDENT_WRITE));
    private final Set<ApplicationPermission> permissions;

    ApplicationUserRole(Set<ApplicationPermission> applicationPermission) {
        this.permissions = applicationPermission;
    }

    public Set<ApplicationPermission> getPermissions() {
        return permissions;
    }
}
