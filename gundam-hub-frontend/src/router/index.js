import { createRouter, createWebHistory } from 'vue-router'
import UniverseList from '@/components/UniverseList.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: UniverseList
  },
  {
    path: '/universes',
    name: 'universes', 
    component: UniverseList
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router