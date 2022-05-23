package com.micropos.carts.mapper;

import com.micropos.common.dto.CartDto;
import com.micropos.common.model.Cart;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface CartMapper {

    Collection<CartDto> toCartsDto(Collection<CartDto> carts);

    Collection<CartDto> toCarts(Collection<CartDto> carts);

    Cart toCart(CartDto cartDto);

    CartDto toCartDto(Cart cart);
}
