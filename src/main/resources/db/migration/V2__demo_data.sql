INSERT INTO author(name)
VALUES ('Jon'), ('Daenerys'), ('Tyron'), ('Cersei'), ('Bran'), ('Arya'), ('Gregor'), ('Jamie'), ('Ned'), ('Sansa');


INSERT INTO post(title, author_id, content)
SELECT
  'Profling lab demo post nr ' || s || ' from author ' || a.name AS title
, a.id AS author_id
, 'Post nr' || s || ': Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec augue ut quam viverra lacinia id in tortor. Nunc aliquam dolor consequat, placerat ligula vitae, venenatis sem. Cras ac nulla scelerisque, tristique augue id, posuere metus. Vivamus sed placerat nisi, quis interdum tortor. Nulla interdum diam at lorem commodo, sit amet aliquam purus dignissim. Etiam elementum purus et sodales bibendum. Sed quis ullamcorper ligula, nec malesuada tellus. Aliquam a nunc est. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla porttitor fringilla nisl vel pulvinar. Nullam tristique eros elit, et tempor libero malesuada malesuada. Nullam ut massa in turpis molestie feugiat. Nam nec metus aliquam metus bibendum maximus at ac risus. Sed sagittis, arcu nec cursus ullamcorper, metus est hendrerit augue, id sodales lorem arcu et justo. Ut fringilla enim quis fermentum scelerisque.' AS content
FROM GENERATE_SERIES(1, 100) s, author a;


INSERT INTO comment(post_id, author_id, content)
SELECT
  p.id AS post_id
, a.id AS author_id
, 'Comment nr ' || s || ' from author ' || a.name || ': Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eget purus nec massa faucibus placerat. Curabitur consectetur auctor risus, at condimentum massa venenatis ac. Phasellus sit amet pharetra metus. Maecenas leo diam, dapibus vitae efficitur in, consectetur blandit sapien. In gravida faucibus laoreet. Nunc congue nisi scelerisque placerat aliquam. In mauris ligula, malesuada nec ante a, luctus facilisis ex. Nullam eleifend nisl eget odio accumsan, vitae ullamcorper est vehicula. Morbi vel accumsan turpis.' AS content
FROM post AS p, generate_series(1, 100) s, author a;
