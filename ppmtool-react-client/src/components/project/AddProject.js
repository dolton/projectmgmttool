import React, { Component } from 'react';
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import {createProject} from '../../actions/projectActions'; 

class AddProject extends Component {

    constructor(){
        super();
        this.state = {
            projectName : "",
            projectIdentifier : "",
            description : "",
            startDate : "",
            endDate : ""
        };

        this.onChange = this.onChange.bind(this);
        // this.onSubmit = this.onSubmit.bind(this);
        this.onSubmit = this.onAddBtnClick.bind(this);
    }

    onChange(e){
        
        this.setState({[e.target.name] : e.target.value})
    }

    onAddBtnClick(e){
        
        if(e && e.target){

            const newProject = {
                projectName : this.state.projectName,
                projectIdentifier : this.state.projectIdentifier,
                description : this.state.description,
                startDate : this.state.startDate,
                endDate : this.state.endDate
            };
    
            if(this.isValidData()){
                this.props.createProject(newProject, this.props.history);
            }
        }
    }

    isValidData(){

        const data =  this.state;
        if(data.projectName.trim !== "" && data.projectIdentifier.trim !== "" 
        && data.description.trim !== ""){

            return true;
        }

        return false;
    }

  render() {
    return (
      <div className="project">
            <div className="container">
                <div className="row">
                    <div className="col-md-8 m-auto">
                        <h5 className="display-4 text-center">Create / Edit Project form</h5>
                        <hr />
                        <form>
                            <div className="form-group">
                                <input type="text" name="projectName" value={this.state.projectName} 
                                className="form-control form-control-lg " placeholder="Project Name" 
                                onChange = {this.onChange}/>
                            </div>
                            <div className="form-group">
                                <input type="text" name="projectIdentifier" value={this.state.projectIdentifier} 
                                className="form-control form-control-lg" placeholder="Unique Project ID" onChange = {this.onChange} />
                            </div>
                            <div className="form-group">
                                <textarea name="description" value={this.state.description} className="form-control form-control-lg" 
                                placeholder="Project Description" onChange = {this.onChange}></textarea>
                            </div>
                            <h6>Start Date</h6>
                            <div className="form-group">
                                <input type="date" value={this.state.startDate} className="form-control form-control-lg" 
                                name="startDate" onChange = {this.onChange} />
                            </div>
                            <h6>Estimated End Date</h6>
                            <div className="form-group">
                                <input type="date" value={this.state.endDate} className="form-control form-control-lg" 
                                name="endDate" onChange = {this.onChange} />
                            </div>

                            <input type="button" value="Create Project" onClick={this.onSubmit} className="btn btn-primary btn-block mt-4" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
  }
};

AddProject.propTypes = {
    createProject : PropTypes.func.isRequired
};

export default connect (
    null, 
    {createProject}
)(AddProject);