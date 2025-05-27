# ALPOS Vulnerability Management System

A **Docker-based** backend vulnerability management system designed to improve scanning efficiency by running parallel scans across multiple containers. Built with **Spring Boot**, **Spring Security**, and **JWT**, the system provides a secure and scalable solution for continuous security assessment.

---

## 🚀 Key Features

- **🔐 Secure RESTful API:**  
  Developed using Spring Boot, Spring Security, Spring Data JPA, and JWT for secure authentication and authorization.

- **🐳 Parallel Scanning with Docker:**  
  Enhances scan performance by launching multiple Docker containers to perform simultaneous host scans.

- **🔍 Vulnerability Detection & Severity Analysis:**  
  Integrated with Nmap to detect vulnerabilities and evaluate their severity level.

- **🛠️ Automated Patch Recommendations:**  
  Generates tailored patch suggestions for each identified vulnerability.

- **⏰ Scheduled & On-Demand Scans:**  
  Supports both periodic scans via scheduling and manual on-demand scans.

- **📄 Reporting & Notifications:**  
  - Export reports in **PDF** and **CSV** formats.  
  - Sends **email notifications** upon scan completion.

- **👥 User Management & RBAC:**  
  Full-featured user and role management system for access control.

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- Nmap CLI Integration
- Docker (for containerized scanning)
- PostgreSQL (or preferred DB)
- Email Service (SMTP)
- PDF/CSV Export Libraries


---

## 📄 License

> Add your license here (e.g., MIT, Apache 2.0)

---

## 🙌 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 📧 Contact

> Add your contact details or links here (GitHub profile, email, etc.)
