import { Routes, Route } from 'react-router-dom';
import Home from 'views/Home';
// import RestaurantDashboard from 'views/RestaurantDashboard';
import NotFound from 'views/NotFound';
import Login from 'views/Login';

function Root() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="*" element={<NotFound />} />
    </Routes>
  );
}

export default Root;
