package data_cookie.session09bt01.controller;

import data_cookie.session09bt01.model.dto.Cart;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("productId") String productId,
                            HttpSession session) {

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.addProduct(productId);

        session.setAttribute("cart", cart);

        return "redirect:/checkout";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session, Model model) {

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            model.addAttribute("message", "Giỏ hàng của bạn đang trống!");
        } else {
            model.addAttribute("message", "Bạn có " + cart.getSize() + " sản phẩm.");
        }

        return "checkout";
    }
}
