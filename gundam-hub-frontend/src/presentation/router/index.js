import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/presentation/views/HomeView.vue')
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('@/presentation/views/AboutView.vue')
  },
  {
    path: '/universe/:id?',
    name: 'universe',
    component: () => import('@/presentation/views/UniverseView.vue')
  },
  {
    path: '/era/:id',
    name: 'era',
    component: () => import('@/presentation/views/EraView.vue')
  },
  {
    path: '/eras',
    name: 'all-eras', 
    component: () => import('@/presentation/views/AllErasView.vue')
  },
  {
    path: '/series',
    name: 'series',
    component: () => import('@/presentation/views/SeriesView.vue')
  },
  {
    path: '/mobile-suits',
    name: 'mobile-suits',
    component: () => import('@/presentation/views/MobileSuitsView.vue')
  },
  {
    path: '/characters',
    name: 'characters',
    component: () => import('@/presentation/views/CharactersView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router