INSERT INTO account (id, create_by, create_time, delete_time, is_deleted, update_by, update_time, version, description, name, password) 
					VALUES (replace(uuid(), '-', ''), NULL, sysdate(), NULL, 0, NULL, NULL, '0', NULL, 'admin', '123456');

INSERT INTO resouce (id, create_by, create_time, delete_time, is_deleted, update_by, update_time, version, description, res_address, res_img, res_name, is_leaf, parent_id, parent_name) 
					VALUES (replace(uuid(), '-', ''), NULL, sysdate(), NULL, 0, NULL, NULL, '0', '系统管理', '/sys', NULL, '系统管理', 0, NULL, NULL);