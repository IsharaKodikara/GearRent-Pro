# Project Description

GearRent Pro is a Java Swing–based desktop application developed for CW2 to manage an equipment rental business.
The system supports multi-branch operations, role-based access control, reservations, rentals, returns, overdue tracking, and reports.

The application follows a Layered Architecture (MVC + Service + DAO) and uses MySQL as the backend database.

# Technology Stack

Java (JDK 8+)

Java Swing (UI)

MySQL (Database)

JDBC (Database connectivity)

Apache NetBeans (IDE)

GitHub (Version control)

# Project Structure

gearrent-pro/
 ├── src/
 │   └── com/ijse/gearrent/
 │       ├── controller/
 │       ├── view/
 │       ├── service/
 │       ├── dao/
 │       ├── dto/
 │       └── util/
 ├── database/
 │   └── gearrent_pro.sql
 └── README.md

# Database Configuration
1️⃣ Create Database

Open MySQL Workbench / phpMyAdmin and run:

DROP DATABASE IF EXISTS gearrent_pro;
CREATE DATABASE gearrent_pro;
USE gearrent_pro;

2️⃣ Create Tables & Insert Sample Data

Run the provided SQL script:

database/gearrent_pro.sql


This script includes:

3 branches

4–5 equipment categories

20+ equipment items

10+ customers with memberships

Sample reservations, rentals, overdue rentals, and damages

# Database Connection Setup

Update your database connection class:

private static final String URL = "jdbc:mysql://localhost:3306/gearrent_pro";
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";

# How to Run the Application

Open the project in Apache NetBeans

Ensure MySQL server is running

Configure database credentials

Run the Main / AppInitializer class

Login using default credentials

# Default Login Credentials
# Admin

Username: admin
Password: admin123

Access: Full system (branches, categories, reports)

# Branch Manager

Username: manager_pan
Password: manager123

Access: Categories, equipment, rentals, returns, reports

# Staff

Username: staff_pan
Password: staff123

Access: Customers, equipment, rentals, reservations

# System Features
# Authentication

Username/password login

Role-based access control (Admin / Manager / Staff)

# Branch Management (Admin)

Add, update, delete branches

# Category Management

CRUD categories

Price factors, weekend multipliers

Activate/deactivate categories

# Equipment Management

CRUD equipment per branch

Assign categories

Status tracking

Search & filters

# Customer Management

CRUD customers

Membership assignment

Rental history tracking

# Reservations

Create & cancel reservations

Validate overlaps

Convert to rentals

# Rentals

Issue rentals

Dynamic price calculation

Membership & long-rental discounts

Payment status tracking

# Returns & Settlement

Late fee calculation

Damage charges

Refund or additional payment

Equipment status update

# Overdue Rentals

View overdue rentals

Days overdue calculation

Customer contact details

# Reports

Branch-wise revenue report

Equipment utilization report

# Architecture

MVC Pattern

Service Layer for business logic

DAO Layer for database access

DTOs for data transfer

Util Package for validation and calculations

# Academic Notes (CW2)

Meets all CW2 functional requirements

Uses Java Swing desktop UI

Uses MySQL relational database

Implements role-based access control

Demonstrates clean layered architecture

# Author

Ishara Shrimali Kodikara
CW2 – Equipment Rental Management System
