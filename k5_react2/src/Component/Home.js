import React from 'react'
import logo from '../logo.svg'
export default function Home() {
  return (
    <div className='w-full h-full flex flex-col justify-center items-center'>
      <div>
        <img src={logo} width='100%' alt='logo' />
      </div>
      <div className='text-xl'>
        K-digital 5기 허선행
      </div>
    </div>
  )
}
