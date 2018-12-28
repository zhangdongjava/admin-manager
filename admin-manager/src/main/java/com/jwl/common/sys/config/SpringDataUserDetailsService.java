package com.jwl.common.sys.config;

import com.jwl.common.sys.model.AdminUser;
import com.jwl.common.sys.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import tk.mybatis.mapper.entity.Condition;

import java.util.Arrays;
import java.util.List;

public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminUserService adminUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Condition condition = new Condition(AdminUser.class);
        condition.createCriteria().andEqualTo("name", username);
        List<AdminUser> list = adminUserService.findByExample(condition);
        if (list == null || list.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        AdminUser adminUser = list.get(0);
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(adminUser.getRoleId());

        UserDetails userDetails = new User(username, adminUser.getPasswd(), Arrays.asList(new SimpleGrantedAuthority[]{simpleGrantedAuthority}));
        return userDetails;
    }
}
