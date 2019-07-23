insert into authorize_local
  (users_id, login_id, password)
values
  ((select max(users_id) from users),
  /*insertAuthorizeEntity.login_id*/'null',
  /*insertAuthorizeEntity.password*/'null'
  );