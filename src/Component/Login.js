import React from 'react'
import LoginForm from './LoginForm'
import Logout from './Logout'
import { useState, useEffect } from 'react'
export default function Login() {
  const [user, setUser] = useState();
  const handleLogin = (userIn) => {
    localStorage.setItem('user', userIn);
    setUser(userIn);
  }
  const handleLogout = () => {
    localStorage.removeItem('user');
    setUser(null);
  }
  useEffect(() => {
    const tmUser = localStorage.getItem('user');
    if (tmUser) setUser(tmUser);
  }, []);

  return (
    <div className='w-full h-auto flex flex-col justify-center items-center'>
      {user ? <Logout user={user} onLogout={handleLogout} /> : <LoginForm onLogin={handleLogin} />}
    </div>
  )
}
