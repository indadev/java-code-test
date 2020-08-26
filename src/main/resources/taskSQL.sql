/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  admin
 * Created: 24 ago. 2020
 */

-- 1. Create a query to return the unique rows in a table

select distinct * 
from clients;

-- 2. Write a command to insert values into a table

insert into clients
(client_name, client_id)
values
('Indalecio', 1);

-- 3. Create a query that joins two tables together. Note, all rows from the 
-- first table must be in the result-set (e.g. given customer and order tables, return all customers and any orders for each customer)

select *
from clients c
left join clients_invoices ci on c.client_id = ci.client_id;  

