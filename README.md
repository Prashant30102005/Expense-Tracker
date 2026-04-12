
# AI Powered Project Expense Analyser

 AI Powered Project Expense Analyser is a Spring Boot REST API application designed to simplify project expense management with AI-powered intelligence.


# Tech Stack

- Java 21 with Spring Boot 4.0.5
- PostgreSQL database with JPA/Hibernate ORM
- llama-3.2-3b-instruct integration for intelligent expense analysis
- Maven build tool
- Docker ready for containerized deployment
## Use Cases

Perfect for teams and managers who need to track build/project costs and understand spending trends through AI-generated insights and recommendations.

## API Endpoints

The application provides 9 RESTful endpoints organized into 4 controller groups:

### Project Management (`/project`)

| Method | Endpoint | Description | Request/Response |
|--------|----------|-------------|------------------|
| POST | `/project/create` | Create a new project | POST: `ProjectDto` → Response: `ProjectDto` |
| GET | `/project/get/{id}` | Retrieve project by ID | Response: `ProjectDto` |
| GET | `/project/getAll` | Retrieve all projects | Response: `List<ProjectDto>` |
| DELETE | `/project/delete/{id}` | Delete a project | Response: `String` (success message) |

### Expense Management (`/expenses`)

| Method | Endpoint | Description | Request/Response |
|--------|----------|-------------|------------------|
| POST | `/expenses/add/{projectId}` | Add expense to project | POST: `ExpenseDto` → Response: `ExpenseDto` |
| GET | `/expenses/project/{id}` | Get all expenses for project | Response: `List<ExpenseDto>` |
| DELETE | `/expenses/delete/{id}` | Delete an expense | Response: `String` (success message) |

### Analysis (`/analysis`)

| Method | Endpoint | Description | Response |
|--------|----------|-------------|----------|
| GET | `/analysis/total/{id}` | Get total project expenses | `double` (total amount) |
| GET | `/analysis/overspending/{id}` | Check overspending status | `boolean` (true/false) |

### AI Insights (`/ai`)

| Method | Endpoint | Description | Response |
|--------|----------|-------------|----------|
| GET | `/ai/insights/{id}` | Get AI-powered spending insights | `String` (analysis text) |

## 🔗 Links
https://expense-tracker-5d09.onrender.com