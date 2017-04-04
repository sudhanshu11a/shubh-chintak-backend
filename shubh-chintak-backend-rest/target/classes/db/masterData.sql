
--Organization Master Data
INSERT INTO `shubhchintak`.`sys_organization` (`id`, `created_by`, `created_date`, `is_active`, `modified_by`, `modified_date`, `organization_name`) VALUES ('1', '1', now(), true, '1', now(), 'Nagarro');

--Tenant Master data
INSERT INTO `shubhchintak`.`sys_tenant` (`id`, `created_by`, `created_date`, `is_active`, `modified_by`, `modified_date`, `tenant_Name`) VALUES ('1', '1', now(), true, '1', now(), 'Technology');

--Role Master Data
INSERT INTO `shubhchintak`.`sys_role` (`id`, `is_active`, `created_by`, `created_date`, `description`, `role_name`, `organization_id`, `tenent_id`) VALUES ('1', true, '1', now(), 'Admin Role', 'admin', '1', '1');

--User Sample Data
INSERT INTO `shubhchintak`.`user` (`id`, `is_active`, `created_by`, `created_date`, `first_name`, `last_name`, `password`, `user_name`, `organization_id`, `tenent_id`) VALUES ('1', true, '1', now(), 'Sudhanshu', 'Sharma', 'sudhanshu', 'sudhanshu', '1', '1');

--User Role Mapping 
INSERT INTO `shubhchintak`.`user_role_mapping` (`user_id`, `role_id`) VALUES ('1', '1');

--Sample menu
INSERT INTO `shubhchintak`.`sys_menu` (`id`, `is_active`, `created_by`, `created_date`, `description`, `label`, `name`, `organization_id`, `tenent_id`) VALUES ('1', true, '1', now(), 'Home Menu', 'Home', 'home', '1', '1');
