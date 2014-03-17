
INSERT INTO `Company` (`id`, `category`, `description`, `name`) VALUES(1, 'Finance', 'concil', 'STA');
INSERT INTO `Company` (`id`, `category`, `description`, `name`) VALUES(2, 'Banking', 'Banking investisement', 'Societe Generale');
INSERT INTO `Company` (`id`, `category`, `description`, `name`) VALUES(3, 'Banking Invesitssement', 'Banking Invesitssement Corporate', 'BNP');
INSERT INTO `Company` (`id`, `category`, `description`, `name`) VALUES(4, 'Insurance', 'insurance and bourse', 'AXA');

--
-- Dumping data for table `Investisor`
--

INSERT INTO `Investisor` (`id`, `profile`) VALUES(2, 2);
INSERT INTO `Investisor` (`id`, `profile`) VALUES(3, 3);
INSERT INTO `Investisor` (`id`, `profile`) VALUES(4, 4);

--
--

INSERT INTO `Portfolio` (`id`, `title`, `owner`) VALUES(41, 'mouddene@wd-tech.org_PF', 3);
INSERT INTO `Portfolio` (`id`, `title`, `owner`) VALUES(43, 'null_PF', 2);



INSERT INTO `Profile` (`id`, `derivatives`, `firstname`, `lastname`, `capitalization`, `term_trading`) VALUES(2, 'yes', 'mouddene', 'elmehdi', 'corporte', '061717734545');
INSERT INTO `Profile` (`id`, `derivatives`, `firstname`, `lastname`, `capitalization`, `term_trading`) VALUES(3, 'yes', 'mouddene', 'mehdi', 'corporte', 'short');
INSERT INTO `Profile` (`id`, `derivatives`, `firstname`, `lastname`, `capitalization`, `term_trading`) VALUES(4, 'yes', 'mouddene', 'mehdi', 'corporte big', 'short');

--
-- Dumping data for table `Role`
--

INSERT INTO `Role` (`id`, `name`) VALUES(1, 'Administrator');
INSERT INTO `Role` (`id`, `name`) VALUES(2, 'Member');
INSERT INTO `Role` (`id`, `name`) VALUES(3, 'Investisor');

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`id`, `createdAt`, `email`, `isActive`, `password`, `username`) VALUES(2, '2014-03-16', 'mouddene@gmail.com', b'1', '606adb13324b789a4278375a05d31242', NULL);
INSERT INTO `User` (`id`, `createdAt`, `email`, `isActive`, `password`, `username`) VALUES(3, '2014-03-16', 'mouddene@wd-tech.org', b'1', 'd9e2c1f6f6c6c3c4065aa0ab38455cf2', 'mouddene@wd-tech.org');
INSERT INTO `User` (`id`, `createdAt`, `email`, `isActive`, `password`, `username`) VALUES(4, '2014-03-16', 'mouddene@gmail.fr', b'1', 'ef0f402041715952ff1f21d50b7af663', 'mouddene@gmail.fr');

--
-- Dumping data for table `User_Role`
--

INSERT INTO `User_Role` (`user_id`, `role_id`) VALUES(2, 3);
INSERT INTO `User_Role` (`user_id`, `role_id`) VALUES(3, 3);
INSERT INTO `User_Role` (`user_id`, `role_id`) VALUES(4, 3);
