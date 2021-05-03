package com.archsoft.util.converter;

import com.archsoft.authentication.model.User;
import com.archsoft.to.UserTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends Converter<User, UserTO>  {
}
