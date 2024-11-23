import { useState } from 'react'
import styles from './App.module.css'
import Navbar from './components/NavBar/Navbar'
import Hero from './components/Hero/Hero'
import About from './components/About/About'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div className={styles.App}>
        <Navbar />
        <Hero />
        <About />
      </div>
    </>
  )
}

export default App
