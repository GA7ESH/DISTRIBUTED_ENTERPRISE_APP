# DISTRIBUTED_ENTERPRISE_APP
HENRY BOOKS INVENTORY SYSTEM : DISTRIBUTED ENTERPRISE SOFTWARE DESIGN AND DEVELOPMENT



INTRODUCTION
This document is used to define terminology specific to the problem domain, explaining terms, which may be unfamiliar to the reader of the use-case descriptions or other project documents. Often, this document can be used as an informal data dictionary, capturing data definitions so that use-case descriptions and other project documents can focus on what the system must do with the information.
DEFINITIONS
The glossary contains the working definitions for the key concepts in the Course Registration System.
6.1 Book
A class offered by the Henry’s Inventory System.
6.2 Branch
The system used for maintain Henry’s Book Inventory System.
6.3 Inventory
A person responsible to admin activities at the Henry’s Branches.
6.4 Inventory Report View
A branch or any user who has access can view Book Inventory Report by Branch
6.5 Admin
A admin can delete, modify master data like branch delete, edit based on access roles(full security features will be develop in the upcoming future releases)

Objectives
The purpose of this document is to define requirements of the Henry Books Inventory System. This document lists the requirements that are not readily captured in the use cases of the use-case model. The Supplementary Specifications and the use-case model together capture a complete set of requirements on the system.


PERFORMANCE
The system shall support up to 2000 simultaneous users against the central database at any given time, and up to 500 simultaneous users against the local servers at any one time. The system shall provide access to the legacy course catalog database with no more than a 10 second latency.


SECURITY
• The system must prevent Branch users from changing any branch information other than their own. Only the Admin can add or edit branch information but role-based security will be added in the future release. Currently delete branch functionality will be disabled • Build secured firewall rule to allow communications between the servers



INTRODUCTION
The following subsections of the Requirements Analysis Document (SRS) document provides an overview of the entire system.
1.1. PURPOSE
This document outlines the usage and implementation of the Mobile Online Henry’s Books Inventory System.
1.2. SCOPE Henry is the owner of a bookstore chain named Henry Books. Henry wants to manage book inventory of each chain using a mobile app. The system is mainly for the Henry and his chain (including all the branches) to maintain and view Book Inventory. • Enable the branches to add branch information • Allow to add book information and availability information by branch • Should have option to view inventory report
1.3. OVERVIEW
The system will let Henry’s chain to manage book’s inventory using mobile android app and his chain including branches can add book and branch information to maintain inventory. This app also useful to view final report to view inventory of the books by branch.
1.4. NEED FOR THE SYSTEM
• The Android app will allow Henery’s chain (branch) to track books and branch information using mobile android phone over the internet. • It allows to add branch demographic information like Branch Name, Address, City, State, zip code and phone number • Android app allows users to add book information like book author, title, description (if any), thumbnail URL and the price of the book • App should allow to enter inventory book availability information like book and associated branch information along with Quantity of books • Finally Android app should have a report view to see Inventory of the books availability by Branch


PROBLEM STATEMENT AND SCOPE
a) The system should enable the branches to add branch information b) The system will allow to add book information and availability information by branch c) The system should have option to view inventory report
III. TIMELINES ✓ Design and requirement gathering will be done by Feb 28th 2023 ✓ Design and Development between Feb 28th 2023 to March 02nd 2023 ✓ Test design will start on March 01st 2023 and Testing targeted for March 03rd 2023 ✓ Estimated to Launch in March 04th 2023
IV. ASSUMPTIONS AND DEPENDENCIES ✓ User must have android phone in order access this application ✓ Android phone should have access to the internet in order to access this application

