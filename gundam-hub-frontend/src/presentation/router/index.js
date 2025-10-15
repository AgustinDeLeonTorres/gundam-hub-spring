import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/presentation/views/home/HomeView.vue')
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('@/presentation/views/about/AboutView.vue')
  },
  {
    path: '/universes',
    name: 'universes', 
    component: () => import('@/presentation/views/universes/UniversesView.vue')
  },
  {
    path: '/universe/:id',
    name: 'universe',
    component: () => import('@/presentation/views/universe/UniverseView.vue')
  },
  {
    path: '/eras',
    name: 'eras',
    component: () => import('@/presentation/views/eras/AllErasView.vue')
  },
  {
    path: '/era/:id',
    name: 'era',
    component: () => import('@/presentation/views/era/EraView.vue')
  },
  {
    path: '/series',
    name: 'series',
    component: () => import('@/presentation/views/series/SeriesView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router