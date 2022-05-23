package com.micropos.carts.service;

import com.micropos.common.model.Cart;
import com.micropos.common.model.Item;
import com.micropos.common.model.Product;
import com.micropos.carts.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
class CartServiceImpl implements CartService {

    private final ProductRepository db;
    private Cart cart;

    public CartServiceImpl(ProductRepository db) {
        this.db = db;
    }

    @Override
    public Cart getCart() {
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    @Override
    public Cart addProduct(String productId) {
        Cart cart = getCart();
        Product product = db.getProduct(productId);
        if (product == null) {
            return cart;
        }
        for (Item item : cart.getItems()) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + 1);
                return cart;
            }
        }
        cart.addItem(new Item(product, 1));
        return cart;
    }

    @Override
    public Cart removeProduct(String productId) {
        Cart cart = getCart();
        Product product = db.getProduct(productId);
        if (product == null) {
            return cart;
        }
        for (Item item : cart.getItems()) {
            if (item.getProduct().equals(product)) {
                cart.removeItem(item);
                return cart;
            }
        }
        return cart;
    }
}
