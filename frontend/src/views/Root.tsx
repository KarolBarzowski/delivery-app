import { Routes, Route } from 'react-router-dom';
// import Home from 'views/Home';
import RestaurantDashboard from 'views/RestaurantDashboard';
import NotFound from 'views/NotFound';

function Root() {
  return (
    <Routes>
      <Route path="/" element={<RestaurantDashboard />} />
      <Route path="*" element={<NotFound />} />
    </Routes>
  );
}

export default Root;
