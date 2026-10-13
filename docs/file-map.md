# Users Feature File Map

## Authentication

GET /login
- Template: login.html
- Form: POST /login
- Fields: username, password

GET /register
- Template: register.html
- Form: POST /register
- Fields: username, password, confirmPassword

POST /logout
- Logs out the authenticated user

## Admin User Management

GET /admin/users
- Template: userAdmin.html
- Model attribute: users

GET /admin/users/edit/{id}
- Template: editUser.html
- Model attribute: user

POST /admin/users/edit
- Fields: id, username, role, enabled

GET /admin/users/delete/{id}
- Template: confirmDeleteUser.html
- Model attribute: user

POST /admin/users/delete
- Field: id

## Access Rules

- /login and /register are public.
- /admin/** requires ADMIN.
- Other protected pages require authentication.