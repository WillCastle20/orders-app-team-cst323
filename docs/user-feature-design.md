## Error and Feedback Planning

### Registration
- Show an error if the username already exists.
- Show an error if passwords do not match.
- Show an error if required fields are missing.
- Display a success message after registration.

### Login
- Show an error for invalid credentials.
- Display registration success feedback when appropriate.

### User Experience
- Display errors near the relevant form.
- Keep entered information when possible.
- Explain how users can correct errors and retry.

## Navigation Bar Design

### Not Logged In
- Show Login and Register links.

### Logged In - Regular User
- Show Logout.

### Logged In - Admin
- Show User Admin and Logout.

### Navigation Rules
- Display links based on authentication and user role.
- Use Thymeleaf sec:authorize for conditional links.
- Logout uses a POST form.
- Do not display admin links to regular users.