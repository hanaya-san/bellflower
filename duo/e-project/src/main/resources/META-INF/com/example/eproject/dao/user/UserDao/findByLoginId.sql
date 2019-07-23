select u.users_id as users_id,
       u.user_name as user_name,
       al.login_id as login_id,
       al.password as password
from
users u
  join
  authorize_local al
    on
  u.users_id = al.users_id
where
  al.login_id = /*loginId*/'null';