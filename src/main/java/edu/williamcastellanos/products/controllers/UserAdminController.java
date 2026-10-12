package edu.williamcastellanos.products.controllers;

import edu.williamcastellanos.products.data.UsersRepository;
import edu.williamcastellanos.products.models.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class UserAdminController {

    private final UsersRepository usersRepository;

    public UserAdminController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // GET /admin/users
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "userAdmin";
    }

    // GET /admin/users/edit/{id}
    @GetMapping("/edit/{id}")
    public String showEditUser(@PathVariable Long id, Model model) {
        UserEntity user = usersRepository.findById(id).orElse(null);

        if (user == null) {
            return "redirect:/admin/users";
        }

        model.addAttribute("user", user);
        return "editUser";
    }

    // POST /admin/users/edit
    @PostMapping("/edit")
    public String updateUser(
            @RequestParam Long id,
            @RequestParam String role,
            @RequestParam(defaultValue = "false") boolean enabled) {

        UserEntity user = usersRepository.findById(id).orElse(null);

        if (user != null) {
            if (!role.equals("USER") && !role.equals("ADMIN")) {
                return "redirect:/admin/users";
            }

            user.setRole(role);
            user.setEnabled(enabled);
            usersRepository.save(user);
        }

        return "redirect:/admin/users";
    }

    // GET /admin/users/delete/{id}
    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(
            @PathVariable Long id,
            Model model) {

        UserEntity user = usersRepository.findById(id).orElse(null);

        if (user == null) {
            return "redirect:/admin/users";
        }

        model.addAttribute("user", user);
        return "confirmDeleteUser";
    }

    // POST /admin/users/delete
    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
        }

        return "redirect:/admin/users";
    }
}