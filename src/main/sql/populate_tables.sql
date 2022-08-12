INSERT INTO product_categories (id, category_name, department, description) VALUES
(1, 'tablet', 'Hardware', 'A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.'),
(2, 'shoes', 'Footwear', 'A shoe with a rubber sole that is designed for people to wear while running, playing sports.'),
(3, 'food', 'Food', 'Products to consume and satisfy your hunger.'),
(4, 'drinks', 'Drink', 'Products to quench your thirst.'),
(5, 'pants', 'Clothing', 'An outer garment covering each leg separately and usually extending from the waist to the ankle'),
(6, 'shirt', 'Clothing', 'a garment for the upper body made of cotton or a similar fabric, with a collar and sleeves, and with buttons down the front.'),
(7, 'computer', 'Hardware', 'An electronic device for storing and processing data, typically in binary form, according to instructions given to it in a variable program.'),
(8, 'smartwatch', 'Accessory', 'a mobile device with a touchscreen display, designed to be worn on the wrist.');

INSERT INTO suppliers (id, supplier_name, description) VALUES
(1, 'amazon', 'Digital content and services'),
(2, 'lenovo', 'Computers'),
(3, 'mjam', 'Food'),
(4, 'zara', 'Clothing'),
(5, 'nike', 'Sportswear'),
(6, 'apple', 'Electronics');

INSERT INTO products (id, product_name, price, currency, description, product_category_id, supplier_id) VALUES
(1, 'Amazon Fire', 49.99, 'USD', 'Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.', 1, 1),
(2, 'Lenovo IdeaPad Miix 700', 479, 'USD', 'Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.', 1, 2),
(3, 'Amazon Fire HD 8', 89, 'USD', 'Amazons latest Fire HD 8 tablet is a great value for media consumption.', 1, 1),
(4, 'Domino''s Pizza', 18, 'USD', 'Best pizza in the neighbourhood', 3, 3),
(5, 'Carbonara', 70, 'USD', 'Organic, home-grown spaghetti with cream', 3, 3),
(6, 'Better Big Mac', 50, 'USD', 'A lot better version of the crappy McDonald''s Big Mac', 3, 3),
(7, 'Air force 1', 2000, 'USD', 'Best selling nike shoes of all times', 2, 5),
(8, 'Tap-dancing shoes', 1, 'USD', 'A must have for every smart person', 2, 4),
(9, 'Converse Run Star Motion', 149, 'USD', 'Perfect for you if you are into weird stuff', 2, 5),
(10, 'Coke', 18, 'USD', 'Most effective drink to give you diabetes', 4, 3),
(11, 'Butter-Beer', 18, 'USD', 'Magical drink to make your loved ones happier.', 4, 1),
(12, 'Coffee', 18, 'USD', 'Liquid gold for free. Just pay the 20 USD shipping fee.', 4, 6),
(13, 'Khaki-pants', 99, 'USD', '“Khakis” and “chinos” are both used to describe casual trousers made with a 100% cotton twill fabric. Technically, “khaki” is a color (light-brown drab), while “chinos” are a style of pant, so strictly speaking, khakis are brown-colored chinos.', 5, 4),
(14, 'Shorts', 49, 'USD', 'Shorts are a garment worn over the pelvic area, circling the waist and splitting to cover the upper part of the legs, sometimes extending down to the knees but not covering the entire length of the leg.', 5, 1),
(15, 'Trousers', 59, 'USD', 'Trousers, also spelled trowsers, also called pants or slacks, an outer garment covering the lower half of the body from the waist to the ankles and divided into sections to cover each leg separately.', 5, 5),
(16, 'Hawaii-Shirt', 1, 'USD', 'A short-sleeved, loose-fitting, open-collar shirt originally worn in Hawaii, made of lightweight fabric printed in colorful, often bold designs of flowers, leaves, birds, beaches, etc.', 6, 4),
(17, 'Polo Shirt', 35, 'USD', 'A close-fitting pullover often knit shirt with short or long sleeves and turnover collar or banded neck.', 6, 3),
(18, 'Voldemort Shirt', 99999, 'USD', 'BEST SHIRT IN THE WHOLE WORLD.', 6, 1),
(19, 'Elder wand Computer', 1337, 'USD', 'Fastest computer and best magic wand in the world.', 7, 6),
(20, 'Not a lenovo Gaming PC', 2999, 'USD', 'A monster gaming pc that will scratch your gaming itch.', 7, 2),
(21, 'Amazon Retro PC', 69, 'USD', 'If you feel like the 80''s and 90''s were better, buy this.', 7, 1),
(22, 'Xiaomi smartwatch', 0.2, 'USD', 'Some chinese crap - Sun Tzu.', 8, 1),
(23, 'Apple watch', 1293, 'USD', 'The most expensive, unneccessary thing in your life, but you will buy it because u addicted bruv.', 8, 6),
(24, 'Garmin Fenix 7X', 999, 'USD', 'Solar powered, sport watch that will make everyone excited to see you run.', 8, 1)