package io.github.manoelpiovesan.entities;

/**
 * @author Manoel Rodrigues
 */
public class LoginCredentials {

        public String email;
        public String password;

        public LoginCredentials() {
        }

        public LoginCredentials(String email, String password) {
            this.email = email;
            this.password = password;
        }
}
