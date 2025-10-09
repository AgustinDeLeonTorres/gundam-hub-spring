import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/views/HomeView.vue';
import UniverseView from '@/views/UniverseView.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView
  },
  {
    path: '/universe/:id',
    name: 'Universe',
    component: UniverseView
  },
  {
    path: '/era/:id',
    name: 'Era',
    component: () => import('@/views/EraView.vue') // Lo crearemos ahora
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;