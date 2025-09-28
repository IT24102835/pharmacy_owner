-- Insert an owner and a staff member for testing
-- Passwords are in plaintext as requested
INSERT INTO staff (username, password, role) VALUES ('owner', 'ownerpass', 'OWNER');
INSERT INTO staff (username, password, role) VALUES ('staff', 'staffpass', 'STAFF');