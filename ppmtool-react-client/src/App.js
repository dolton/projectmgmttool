import React, { Component } from 'react';
import './App.css';
import Dashboard from './components/Dashboard';
import Header from './components/layout/Header';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import AddProject from './components/project/AddProject';
import {Provider} from 'react-redux';
import store from './store';

class App extends Component {
  render() {
    return (
      // This is a common store for every component which is provided using the Provider
      <Provider store={store}>
        <Router>
          <div className="App">
            <Header></Header>
            <Route exact path="/dashboard" component={Dashboard}></Route>
            <Route exact path="/addProject" component={AddProject}></Route>
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
