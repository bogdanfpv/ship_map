import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import React, { useEffect, useState } from 'react';

function App() {
  const [data, setData] = useState(null);

  useEffect(() => {
    // Function to fetch data
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/ships/unique-names?start=${start}&end=${end}');
        setData(response.data);
      } catch (error) {
        console.error('Failed to fetch data:', error);
      }
    };

    // Fetch data when component mounts
    fetchData();

    // Set up interval to fetch data every hour
    const now = new Date();
    const delay = ((60 - now.getMinutes()) * 60 - now.getSeconds()) * 1000;
    const intervalId = setInterval(fetchData, 60 * 60 * 1000, delay);

    //Get the next start and end time values to include in the query

    now.setMinutes(0);
    now.setSeconds(0);
    if (now.getTime() === new Date().getTime()) {
        now.setHours(now.getHours() + 1);
    }

    //Converting ISO to org.springframework.format.annotation.DateTimeFormat

    let start = now.toISOString().replace('T', ' ').substring(0, 19);
    
    now.setHours(now.getHours() + 1);
    let end = now.toISOString().replace('T', ' ').substring(0, 19);

    // Clear interval on component unmount
    return () => clearInterval(intervalId);
  }, []); // Empty dependency array means this effect runs once on mount and clean up on unmount

  return (
    <div className="App">
      {/* Render your data here */}
    </div>
  );
}

export default App;
