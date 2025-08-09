import { createRoot } from 'react-dom/client'
import './index.css'
// import App from './App.jsx'
// import { myVar, num } from './App.jsx'
import App, { myVar, num } from './App'
import { num as carNum } from './components/Car'

console.log(`myVar = ${myVar}, num = ${num}, carNum = ${carNum}`)
createRoot(document.getElementById('root')).render(<App />)
