import { compose, createStore as reduxCreateStore} from 'redux';
import goStarterKit from './reducers';
import { persistState } from 'redux-devtools';
import DevTools from './router/devtools'

let finalCreateStore;
if (process.env.NODE_ENV === 'production') {
  finalCreateStore = reduxCreateStore.bind(null, goStarterKit);
} else {
  try {
    finalCreateStore = compose(
      DevTools.instrument(),
      persistState(window.location.href.match(/[?&]debug_session=([^&]+)\b/))
    )(reduxCreateStore).bind(null, goStarterKit);
    console.log('dev tools added');
  } catch (e) {
    finalCreateStore = reduxCreateStore.bind(null, goStarterKit);
  }
}

export const createStore = finalCreateStore;
