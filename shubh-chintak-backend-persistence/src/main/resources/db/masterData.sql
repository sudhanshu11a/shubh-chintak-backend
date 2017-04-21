
--Organization Master Data
INSERT INTO `shubhchintak`.`sys_organization` (`id`, `created_by`, `created_date`, `is_active`, `modified_by`, `modified_date`, `organization_name`) VALUES ('1', '1', now(), true, '1', now(), 'Nagarro');

--Sample menu
INSERT INTO `shubhchintak`.`sys_menu` (`id`, `is_active`, `created_by`, `created_date`, `description`, `label`, `name`, `organization_id`) VALUES ('1', true, '1', now(), 'Settings', 'Setting', 'seting', '1');

--Role Master Data
INSERT INTO `shubhchintak`.`sys_role` (`id`, `is_active`, `created_by`, `created_date`, `description`, `role_name`, `organization_id`) VALUES ('1', true, '1', now(), 'Admin Role', 'ROLE_ADMIN', '1');

--User Sample Data
INSERT INTO `shubhchintak`.`address` (`id`, `is_active`, `created_by`, `created_date`, `modified_by`, `city`, `organization_id`) VALUES ('1', true, '1', now(), '', 'New Delhi', '1');
INSERT INTO `shubhchintak`.`user_details` (`id`, `is_active`, `created_by`, `created_date`, `first_name`, `last_name`, `organization_id`, `address`) VALUES ('1', true, '1', now(), 'Sudhanshu', 'Sharma', '1', '1');
INSERT INTO `shubhchintak`.`user` (`id`, `is_active`, `created_by`, `created_date`, `password`, `user_name`, `organization_id`, `user_details`) VALUES ('1', true, '1', now(), 'sudhanshu', 'sudhanshu', '1', '1');

--User Sample Role Mapping 
INSERT INTO `shubhchintak`.`user_role_mapping` (`user_id`, `role_id`) VALUES ('1', '1');

