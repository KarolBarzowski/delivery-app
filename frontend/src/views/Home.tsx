import axios from 'axios';
import { useEffect } from 'react';

const Home = () => {
  useEffect(() => {
    axios.get('/test').then((data) => console.log(data));
  }, []);

  return <div>Home</div>;
};

export default Home;
