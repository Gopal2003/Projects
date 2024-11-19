import { useState } from 'react'
import styles from './App.module.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div className={styles.App}>Hello World</div>
    </>
  )
}

export default App
