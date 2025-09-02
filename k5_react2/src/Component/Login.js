import React, { useState, useEffect } from 'react';
import LoginForm from './LoginForm';
import Logout from './Logout';
import { useRecoilState } from 'recoil';
import { stLogin } from './StAtom';

export default function Login() {
  const [user, setUser] = useState();
  const [isLogin, setIsLogin] = useRecoilState(stLogin);

  const handleLogin = (userIn) => {
    localStorage.setItem('user', userIn);
    setUser(userIn);
    setIsLogin(true);
  };

  const handleLogout = () => {
    localStorage.removeItem('user');
    setUser(null);
    setIsLogin(false);
  };

  useEffect(() => {
    const tmUser = localStorage.getItem('user');

    if (tmUser) {
      setUser(tmUser);
    } else {
      // Handle the case when there is no user in local storage
      // For example, you can redirect to a login page or do some other action
    }
  }, []);

  return (
    <div className='w-full h-auto flex flex-col justify-center items-center'>
      {isLogin ? (<Logout user={user} onLogout={handleLogout} />)
               : (<LoginForm onLogin={handleLogin} />) }
    </div>
  );
}
