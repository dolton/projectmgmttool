import React, { Component } from 'react';
import './App.css';
import Dashboard from './components/Dashboard';
import Header from './components/layout/Header';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import AddProject from './components/project/AddProject';

class App extends Component {
  render() {
    return (
      <Router>
        <div className="App">
          <Header></Header>
          <Route exact path="/dashboard" component={Dashboard}></Route>
          <Route exact path="/addProject" component={AddProject}></Route>
        </div>
      </Router>
    );
  }
}

export default App;
