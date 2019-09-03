import React from 'react';
import './App.css';
import Search from './pages/search';
import { getData } from './services/data';


const App = () => {
    return (
        <div className="App">
            <Search getData={getData}/>
        </div>
    );
};

export default App;
