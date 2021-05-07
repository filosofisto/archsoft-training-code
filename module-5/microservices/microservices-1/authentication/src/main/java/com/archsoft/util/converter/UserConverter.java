package com.archsoft.util.converter;

import com.archsoft.model.User;
import com.archsoft.to.UserTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends Converter<User, UserTO>  {
}
